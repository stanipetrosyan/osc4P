package osc4P

import io.vertx.core.Vertx
import io.vertx.core.datagram.DatagramSocketOptions
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import osc4P.api.Client
import osc4P.domain.OscMessage

@ExtendWith(VertxExtension::class)
class UdpClientTest {
  private val port: Int = 9998
  private val host: String = "localhost"
  private val client: Client = Client.create(port, host)

  @Test
  fun `should send to an udp client`(vertx: Vertx, test: VertxTestContext) {
    val socket = vertx.createDatagramSocket(DatagramSocketOptions())
    val oscPacket = OscMessage()

    socket
      .handler { packet ->
        Assertions.assertThat(packet.data().toString()).isEqualTo("a test")
        test.completeNow()
      }
      .listen(port, host)

    client.send("a test")
  }
}