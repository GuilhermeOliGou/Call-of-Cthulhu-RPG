interface FacadeBaseDados {
  
  void leItem(Item item);
  
  void escreveItem(Item item);
  
  void listaItens(Jogador jogador);
  
  void leItemChave(ItemChave itemChave);
  
  void escreveItemChave(ItemChave itemChave);
  
  void listaItensChave(Jogador jogador);
  
  void leItemConsumivel(ItemConsumivel itemConsumivel);
  
  void escreveItemConsumivel(ItemConsumivel itemConsumivel);
 
  void listaItensConsumiveis(Jogador jogador);
  
  void leArma(Arma arma);
  
  void escreveArma(Arma arma);
  
  void listaArmas(Jogador jogador);
  
  void leArmaBranca(ArmaBranca armaBranca);
  
  void escreveArmaBranca(ArmaBranca armaBranca);
  
  void listaArmasBrancas(Jogador jogador);
  
  void leArmaDeFogo(ArmaDeFogo armaDeFogo);
  
  void escreveArmaDeFogo(ArmaDeFogo armaDeFogo);
  
  void listaArmasDeFogo(Jogador jogador);
  
  void leJogador(Jogador jogador);
  
  void escreveJogador(Jogador jogador);
  
  void listaJogadores();
  
  void lePersonagem(Personagem personagem);
  
  void escrevePersonagem(Personagem personagem);
  
  void listaPersonagens();

}
