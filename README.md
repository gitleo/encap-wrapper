Encapsulador/Wrapper
====================

<p>Pacote desenvolvido na linguagem amplamente conhecida no mundo dos programadores e designers, JAVA. Seu intuito é abstrair algumas das funcionalidades do mural da plataforma social de educação Redu, livrando o desenvolvedor dos detalhes referentes à rede de comunicação.</p>

<h2>Iniciando...</h2>

<p>Para começar é necessário criar objeto do tipo FachadaDoREDU. Preencha os parâmetros segundo solicitado os mesmos.</p>

```java
FachadaDoREDU fachada = new FachadaDoREDU("sua_chave_consumidora", "sua_chave_secreta");
```

<p>Para continuar, você precisa da sequência do seu pin de autenticação, depois já é possível inicializar o cliente.</p>

```java
System.out.print("Preparando busca deste endereço web: " + fachada.getAuthorizeUrl());
System.out.println();
System.out.print("Agora, a sua sequência pin:");
System.out.println();
// Logo abaixo, uma sequência pin é passada como parâmetro. É do tipo String. Você também pode separar os objetos aqui se achar pouco legível. =P
fachada.iniciaCliente(new Scanner(System.in).nextLine());
```

<h2>Testando...</h2>

<p>A próxima linha serve para descobrir se a autenticação foi realizada com sucesso, mostrando informações do login fornecido.</p>

```java
System.out.println(fachada.getEu());
```

<p>Faz-se necessário usar a sequência pin uma única vez. De posse do mesmo siga o passo seguinte.</p>

```java
FachadaDoREDU fachada = new FachadaDoREDU("sua_chave_consumidora", "sua_chave_secreta", "sua_sequencia_pin");
```

<h2>Aprofundando um pouco mais</h2>

<p>Depois de realizar a linha acima, ou seja, criar o objeto, as ações possíveis do encapsulador estão liberadas para uso.</p>

<p>Vejamos como criar um post no seu mural.</p>

```java
// O parâmetro do System é um Status do tipo post. É a postagem do Usuário.
System.out.println(fachada.postStatusDoUsuario("seu_id", "o_post"));
```
<p>Agora, responder ao post.</p>

```java
// O Status aqui é uma resposta. Em id_status é válido somente o tipo Help ou Activity.
System.out.println(fachada.postResposta("id_status", "o_texto_da_resposta_seja_pedido_de_ajuda_ou_comentário"));
```

<p>Aprenda a listar os tipos status de um espaço em uma mesma lista. Alguns parâmetros são opcionais, então você pode passar null para eles.</p>

```java
List<Status> listaStatus = fachada.getStatusPorEspaco("id_disciplina_com_acesso_garantido", "Log", null); // Log é um dos tipos de Status.
  	for(Status postagens : listaStatus){
			System.out.println(postagens);
	}
```


<h2>Quer colaborar? =]</h2>

1. Comece pelo fork do projeto;
2. Depois novo branch deve ser criado;*
3. Não esquecer dos commits;*
4. Push nas modificações;*
5. Tudo feito é só enviar um pull request.
*Este passo é realizado com comandos git seguido de checkout, commit e push respectivamente. Para maiores detalhes consulte a documentação do Git ou faça uma pesquisa (rápida) no Google. :p

<h2>Copyright</h2>

<p>Copyright (c) 2013 Redu Educational Technologies.</p>

<p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:</p>

<p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.</p>

<p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</p>