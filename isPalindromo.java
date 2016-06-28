public boolean isPalindromo(Pilha p) {
   
   if(p == null || p.size() == 0) {
      return false;
   } else if(p.size() == 1) {
      return true;
   } else {
      Pilha e = new Pilha();          // pilha auxiliar recebe os elementos da primeira metade da pilha p
      Pilha d = new Pilha();          // pilha auxiliar recebe os elementos da segunda metade da pilha p
      Pilha auxe = new Pilha();       // pilha auxiliar para armazenar elementos da pilha e e inverter pilha
      Pilha auxd = new Pilha();       // pilha auxiliar para armazenar elementos da pilha d e inverter pilha
      Pilha m = new Pilha();          // pilha auxiliar recebe elemento do meio da pilha
      
      int half = p.size()/2;
      
      // p >>> e
      transfere(p, e, half);
      
      if(half < p.size())             // se a pilha e tiver elemento a mais que a metade, ent este eh o do meio
         m.push(p.pop());
      
      // p >>> auxd
      transfere(p, auxd, half);       // inverter a pilha para comparar com a pilha e
      // auxd >>> d
      transfere(auxd, d, half);
      
      int cont = 0;                   // contador de elementos nao-palindromos
      
      for(int i = 0; i < half; i++) {
         if(e.peek().getInfo() != d.peek().getInfo())
            cont++;
            
         auxe.push(e.pop());
         auxd.push(d.pop());
      }
      
      // auxe >>> p
      transfere(auxe, p, half);
      
     
      p.push(m.pop());                // elemento do meio
                                      // se for nulo, a pilha nao faz push
     
      // auxd >>> d
      transfere(auxd, d, half);       // inverter a pilha d para retornar para a pilha p
      
      // d >>> p
      transfere(d, p, half);
   }
   
   return cont == 0 ? true : false;
}

private void transfere(Pilha pop, Pilha push, int qtd) {
   for(int i = 0; i < qtd; i++) {
      push.push(pop.pop());
   }
}


///






