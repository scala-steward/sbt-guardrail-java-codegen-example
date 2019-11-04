package support

import com.example.clients.petstore.Implicits

class PositiveLong private (val value: Long) extends AnyVal

object PositiveLong {
  def apply(value: Long): Option[PositiveLong] = if (value >= 0) Some(new PositiveLong(value)) else None
}
