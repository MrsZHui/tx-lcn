package com.codingapi.txlcn.protocol.manager.network.message.ping;

import com.codingapi.txlcn.protocol.IPeer;
import com.codingapi.txlcn.protocol.manager.Peer;
import com.codingapi.txlcn.protocol.message.Connection;
import com.codingapi.txlcn.protocol.message.Message;

public class CancelPongs implements Message {

  private static final long serialVersionUID = 5147827390577329607L;

  private final String peerName;

  public CancelPongs(String peerName) {
    this.peerName = peerName;
  }

  @Override
  public void handle(IPeer peer, Connection connection) {
    peer.optional(Peer.class).ifPresent((p) -> p.cancelPongs(peerName));
  }

  @Override
  public String toString() {
    return "RemovePongs{" +
        "peerName='" + peerName + '\'' +
        '}';
  }

}
