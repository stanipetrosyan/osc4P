package osc4P.api

import osc4P.UdpClient

interface Client {

  companion object {
    @JvmStatic
    fun create(port: Int, host: String): Client = UdpClient(port, host)
  }

  fun send(message: String)
}