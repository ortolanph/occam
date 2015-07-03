# Occam

## Apresentação

Occam é um framework web acadêmico desenvolvido como um trabalho em grupo do curso de Tecnologias e Arquiteturas na Construção de Software do SENAC. A disciplina era a de Design Arquitetural de Software OO e como trabalho final, toda a turma foi envolvida na construção de uma aplicação web. Foram divididos três grupos para construir essa aplicação web. Um dos grupos, no qual me encontrava, era para fazer o framework web. Surgia assim o framework Occam.

Como requisitos para a construção do framework, foram listados:

1. Injeção de Dependências
2. Inversão de Controle

De posse dos requisitos, comecei a pensar em como construir o framework. A primeira coisa que pensei foi:  "Devo fazer o mais simples possível!". Daí o nome: Occam em homenagem à Navalha de Occam, como na citação extraída da Wikipedia:

Se em tudo o mais forem idênticas as várias explicações de um fenômeno, a mais simples é a melhor

## Conceitos

Comecei a me lembrar de todos os frameworks web com os quais já trabalhei e pensei na tecnologia PUSH. Como algo simples, pensei em imitar o STRUTS com um servlet que processa todas as chamadas de um padrão URL. O que está depois dessa porta de entrada é o mais interessante.

### Porta de Entrada

No framework, tudo é uma Operacao. Seu POJO é anotado com @Operation, transformando em uma operação do Occam. O desenvolvedor ainda pode configurar se a Operação que está desenvolvendo é SINGLETON, ou seja, possui uma instancia única durante o tempo de execução do sistema, ou PROTOTYPE, ou seja, a cada request, cria uma nova instância da classe de Operação.

Ainda na Operação, cada atributo da classe pode mapear os atributos do formulário da página da web. Para que isso aconteça, seus atributos devem estar anotados com @Bean. Na parte Campos do formulário explico melhor como essa mágica acontece.

Convencionei que todas as ações do formulários fossem operacao.metodo, onde  metodo é um método da classe da operação e tiver a anotação @NavigationCases, que irá realizar o redirecionamento correto conforme a execução correta ou não do método. Outra regra é que ele não pode ter parâmetros.

A ideia da anotação @NavigationCases é o de redirecionar a navegação para uma página quando  o processo finaliza com sucesso ou quando finaliza com falha. Desse modo, o desenvolvedor somente precisa configurar nesse ponto o redirecionamento.

Para completar a parte de entrada, o desenvolvedor deve configurar pelo menos um arquivo XML para que o framework encontre as operações desenvolvidas. O arquivo é o operation.xml e deve estar localizado no diretório WEB-INF junto com o arquivo WEB.XML. A raiz do arquivo é representada pela tag operations e possui tags filhas operation. Cada operation possui os atributos name com o nome da operação, que é mapeada para a operacao da action do formulário, e class que é a implementação dessa operação.

Com isso, finaliza a porta de entrada do Framework.

Servlet

Para o imitar o STRUTS, foi necessário criar um servlet, que escuta todas as requisições no padrão url   /occam/operacao.metodo. O servlet obtém o substring e orquestra, por meio de um facade o fluxo do framework.

Após a conclusão do processo, é responsável também por fazer o redirecionamento correto.

O desenvolvedor não precisa se preocupar em declarar o servlet no WEB.XML, pois o projeto occam-servlet foi pensado como um web-fragment, que necessita declarar no arquivo web-fragment.xml todos os servlets, filters e outros recursos de aplicação web java. Esse recurso está disponível no Java EE6. Basta somente instalar em um servidor de aplicações Java EE6 que o servlet já é carregado.

Injeção de Dependências

Esta parte do framework é basicamente representado por um Service Locator.  O servlet carrega o arquivo de configuração e passa uma URL e o nome da operação para o Service Locator, que implementa o padrão de projeto Singleton. A principal responsabilidade é de procurar a classe daquela operação em um HashMap interno e, se for necessário, criar uma instância dessa classe.

Ao criar a instância da classe, o Service Locator irá buscar a tag @Operation para verificar a estratégia de instância. Se a estratégia for SINGLETON, a instância da classe será armazenada no HashMap interno, senão (PROTOTYPE), irá resolver as dependências anotadas com @Inject do Java EE6 e retornar a instância para o servlet.

Campos do formulário

Antes da execução do método, o framework irá carregar os dados do formulário para os atributos que estiverem anotados com @Bean da instância da classe resolvida pelo Service Locator. O servlet irá passar um HashMap de Strings que representam os campos e os valores do formulário.

Para cada tipo primitivo existe uma classe mapeada para fazer a conversão. Existe também uma classe mapeada para o tipo String e para o tipo Date, que em particular atende a somente um formato.

Para que não houvessem problemas na conversão dos dados, a direção da conversão sempre é dos dados do formulário para os campos Bean. Assim, pode-se eliminar o problema de Nullpointers, mas ainda existe o problema de NoSuchFieldException.

Execução do Método

Basicamente, o executor de método invoca o método definido na action do formulário dentro de um try-catch. Se houver algum problema, o framework irá redirecionar para a página de erro definido no método da Operação na annotation NavigationCases do caso FAIL.

O contrário acontece quando o método é executado com sucesso. O que mais acontece nesse caso é que se existir um retorno, esse objeto será registrado na request.

The Return of the Request (aka Response)

Após a execução do método, ocorrendo ou não com sucesso, o framework lerá o valor da annotation NavigationCases e irá redirecionar para o caso adequado. Se a execução falhou, será redirecionado para a URL de erro, senão para a de sucesso com o retorno na request, se o método tem algo para retornar.

O detalhe é que o retorno será salvo na request com o nome de bean. O desenvolvedor deve lembrar de usar o tipo correto do retorno quando utilizar a tag jsp:useBean.

Com isso termino de explicar como funciona o framework Occam. Espero que tenha despertado em alguém o interesse por fazer um exemplo.

Para baixar acesse os links a seguir:

occam-servlet - O servlet
occam-infra - O pacote de infra-estrutura
occam - O arquivo JAR que deve ser incorporado no projeto

Existe ainda um tutorial que explica passo a passo a construção de uma aplicação básica com o framework.

Existem dois exemplos:

Calculadora: Uma calculadora simples
Hello, World: O exemplo que não podia faltar!
Por que usar Occam?


1. Framework leve
2. Fácil de configurar
3. Fácil de implementar
4. Free!

### Por que NÃO usar Occam?

1. Possui falhas
2. Não possui um sistema de Exceptions muito bem definido
3. O Service Locator não clona instâncias, portanto instâncias são reutilizadas
4. Não possui um conversor para Array
5. O conversor de datas não permite outro formato
6. Não possui redirecionamentos customizados
7. É acadêmico e não sei quando darei manutenção nele
8. Mais um framework web, pra quê?

Algumas outras coisas...

Vocês estão convidados a usar, criticar, xingar e olhar o código.