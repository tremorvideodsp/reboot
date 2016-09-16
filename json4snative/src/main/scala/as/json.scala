package dispatch.as.json4s

import org.asynchttpclient.Response
import org.json4s._
import org.json4s.native.JsonMethods._

object Json extends (Response => JValue) {
  def apply(r: Response) =
    (dispatch.as.String andThen (s => parse(StringInput(s), true)))(r)
}
