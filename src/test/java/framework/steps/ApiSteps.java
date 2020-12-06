package framework.steps;

import com.google.gson.Gson;
import framework.model.Persona;
import framework.model.pojo.Access;
import framework.model.pojo.TeamAccess;
import framework.model.pojo.Board;
import framework.model.pojo.SharingPolicy;
import framework.utils.TestData;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.jbehave.core.annotations.Given;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    private static final String ACCOUNT_ID_QUERY_PARAM = "accountId";
    private static final String AUTH_HEADER_NAME = "Authorization";
    private static final String BOARD_ROUTE = "/boards";

    @Given("a board '$boardName' is created by $persona")
    public void createBoard(final String boardName, final String personaName) {
        String creatorAccountrId = TestData.getPersonaByName(personaName).getAccountId();
        Board newBoard = createBoardBody(boardName, Access.VIEW, TeamAccess.VIEW);

        given()
                .contentType(ContentType.JSON)
                .queryParam(ACCOUNT_ID_QUERY_PARAM, creatorAccountrId)
                .header(AUTH_HEADER_NAME, TestData.getAuthorizationToken())
                .body(new Gson().toJson(newBoard))
                .when()
                .post(BOARD_ROUTE)
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    private Board createBoardBody(final String boardName, final Access generalAccess, final TeamAccess teamAccess) {
        return new Board()
                .setName(boardName)
                .setSharingPolicy(
                        new SharingPolicy()
                                .setAccess(generalAccess)
                                .setTeamAccess(teamAccess)
                );
    }
}
