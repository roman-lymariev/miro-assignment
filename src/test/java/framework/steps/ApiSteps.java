package framework.steps;

import framework.model.Access;
import framework.model.TeamAccess;
import framework.model.pojo.*;
import framework.utils.TestData;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.jbehave.core.annotations.Given;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    private static final String AUTH_HEADER_NAME = "Authorization";
    private static final String BOARDS_ROUTE = "/boards";
    private static final String DELETE_BOARD_ROUTE = "/boards/%s/trash";


    @Given("a shared board '$boardName' is created")
    public void createBoard(final String boardName) {
        CreateBoardBody newBoard = getCreateBoardBody(boardName, Access.VIEW, TeamAccess.VIEW);

        Response response = given()
                .contentType(ContentType.JSON)
                .header(getAuthHeader())
                .body(newBoard)
                .when()
                .post(BOARDS_ROUTE);

        response.then()
                .statusCode(HttpStatus.SC_CREATED);

        //save for later use
        Board board = response.getBody().as(Board.class);
        TestData.setBoardId(board.getId());
        TestData.setBoardViewLink(board.getViewLink());
    }

    @Given("the board is deleted")
    public static void deleteBoard() {
        Response response = given()
                .header(getAuthHeader())
                .accept(ContentType.JSON)
                .when()
                .post(getDeleteBoardRoute());

        response
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    // --- reusable methods ---
    private static Header getAuthHeader() {
        return new Header(AUTH_HEADER_NAME, TestData.getAuthorizationToken());
    }

    private static String getDeleteBoardRoute() {
        return String.format(DELETE_BOARD_ROUTE, TestData.getBoardId());
    }

    private CreateBoardBody getCreateBoardBody(final String boardName, final Access generalAccess, final TeamAccess teamAccess) {
        return new CreateBoardBody()
                .setName(boardName)
                .setSharingPolicy(
                        new SharingPolicy()
                                .setAccess(generalAccess)
                                .setTeamAccess(teamAccess)
                );
    }
}
