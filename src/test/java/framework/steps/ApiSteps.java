package framework.steps;

import framework.model.pojo.*;
import framework.utils.TestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.jbehave.core.annotations.Given;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    private static final String AUTH_HEADER_NAME = "Authorization";
    private static final String BOARDS_ROUTE = "/boards";
    private static final String DELETE_BOARD_ROUTE = "/boards/%s/trash";

    @Given("a board '$boardName' is created")
    public void createBoard(final String boardName) {
        CreateBoardBody newBoard = createBoardBody(boardName, Access.VIEW, TeamAccess.VIEW);

        Response response = given()
                .contentType(ContentType.JSON)
                .header(AUTH_HEADER_NAME, TestData.getAuthorizationToken())
                .body(newBoard)
                .when()
                .post(BOARDS_ROUTE);

        response.then()
                .statusCode(HttpStatus.SC_CREATED);

        //save for later use
        Board board = response.getBody().as(Board.class);
        TestData.setBoardId(
                board.getId()
        );
        TestData.setBoardViewLink(
                board.getViewLink()
        );
    }

    @Given("the board is deleted")
    public static void deleteBoard() {
        final String deleteBoardRoute = String
                .format(DELETE_BOARD_ROUTE, TestData.getBoardId())
                .replace("=", "%3D");

        Response response = given()
                .header(AUTH_HEADER_NAME, TestData.getAuthorizationToken())
                .contentType(ContentType.JSON)
                .when()
                .post(deleteBoardRoute);

        response
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    private CreateBoardBody createBoardBody(final String boardName, final Access generalAccess, final TeamAccess teamAccess) {
        return new CreateBoardBody()
                .setName(boardName)
                .setSharingPolicy(
                        new SharingPolicy()
                                .setAccess(generalAccess)
                                .setTeamAccess(teamAccess)
                );
    }
}
