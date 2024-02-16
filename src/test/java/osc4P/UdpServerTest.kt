package osc4P

import io.vertx.core.Vertx
import io.vertx.core.datagram.DatagramSocketOptions
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import osc4P.api.Server


@ExtendWith(VertxExtension::class)
class UdpServerTest {

  private val port: Int = 9998
  private val host: String = "localhost"
  private val server: Server = Server.create(port, host)

  @Test
  fun `should receive an osc message`(vertx: Vertx, test: VertxTestContext) {
    val socket = vertx.createDatagramSocket(DatagramSocketOptions())

    server.serve()
      .handler { packet ->
        assertThat(packet.data().toString()).isEqualTo("a test")
        test.completeNow()
      }
      .listen(port, host)

    socket.send("a test", port, host)
  }
}