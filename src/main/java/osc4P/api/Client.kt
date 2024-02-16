package osc4P.api

interface Client {

  companion object {
    @JvmStatic
    fun create(port: Int, host: String): Client = UdpClient(port, host)
  }

  fun send(message: String)
}