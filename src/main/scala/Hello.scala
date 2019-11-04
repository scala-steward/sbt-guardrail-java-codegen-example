package helloworld

import java.util
import java.util.Optional
import java.util.concurrent.{CompletableFuture, CompletionStage}

import scala.concurrent.Future
import com.example.clients.petstore.AsyncHttpClientSupport

object Hello {
  def main(args: Array[String]) = {
    import com.example.clients.petstore.user.UserClient
    import scala.concurrent.ExecutionContext.Implicits.global

    val server = buildServer()

    val userClient = new UserClient.Builder().build()
    val userByNameResponse = userClient.getUserByName("billg").call()

    System.out.println(userByNameResponse)
  }

  private def buildServer(): String = {
    import com.example.servers.petstore.user._
    import com.example.servers.petstore.{definitions => sdefs}
    ???
  }
}

class DummyUserHandler
  extends com.example.servers.petstore.user.UserHandler {

  import com.example.servers.petstore.user._
  import com.example.servers.petstore.user.UserHandler.GetUserByNameResponse
  import com.example.servers.petstore.definitions._

  override def createUser(body: User): CompletionStage[UserHandler.CreateUserResponse] = ???

  override def createUsersWithArrayInput(body: util.List[User]): CompletionStage[UserHandler.CreateUsersWithArrayInputResponse] = ???

  override def createUsersWithListInput(body: util.List[User]): CompletionStage[UserHandler.CreateUsersWithListInputResponse] = ???

  override def loginUser(username: String, password: String): CompletionStage[UserHandler.LoginUserResponse] = ???

  override def logoutUser(): CompletionStage[UserHandler.LogoutUserResponse] = ???

  override def getUserByName(username: String): CompletionStage[GetUserByNameResponse] = {
    val user = new User.Builder().withId(1234)
        .withUsername(username)
        .withFirstName("First")
        .withLastName("Last").build()
    CompletableFuture.completedFuture(UserHandler.GetUserByNameResponse.Ok(user))
  }

  override def updateUser(username: String, body: User): CompletionStage[UserHandler.UpdateUserResponse] = ???

  override def deleteUser(username: String): CompletionStage[UserHandler.DeleteUserResponse] = ???
}
