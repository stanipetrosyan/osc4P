package osc4P.api

import osc4P.domain.OscMessage

interface Client {
  fun send(message: OscMessage)
}