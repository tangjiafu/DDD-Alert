package org.example.vo

/**
 * ${description}
 *
 * @author Lager.Tang
 *         create: 2022-04-10 19:34
 * */
case class Response(code: Int, message: String, cost: Int, req: String, result: Object) {

}

object Response {
  def success(result: Object): Response = {
    Response(200, "success", 0, null, result)
  }
}
