# ProjetoFinal Insider Threat
Alunx(s): [Ana Clara](github.com/claranobre) e [Felipe Gilberto](github.com/felipeegil) 

Este projeto consiste na implementação de um sistema orientado a objetos que permita a representação de perfis de usuários a partir de arquivos de log, e sua posterior visualização e comparação de forma a identificar usuários com comportamento suspeito. O sistema
a ser desenvolvido deverá receber como entrada arquivos de log em formato csv, contendo uma sequência de atividades observadas.

## Objetivos Específicos

1. Leitura de arquivos de log como entrada de dados.
2. Montagem dos perfis de usuários.
3. Visualização dos perfis de usuários.
4. Detecção de anomalias.

## Estruturas Utilizadas
Nós utilizamos a estrutura de dados ArrayList para armazenar e analisar os dados para criarmos os perfis dos usuários.
Foi escolhida a Arvore Binaria de Busca como modelo de gerenciamento da hierarquia do projeto

## Abordagem da Solução dos problemas
Foi desenvolvido o cálculo do desvio padrão de todos os usuários de um dia informado pelo operador do sistema, comparando ao desvio padrão do usuário buscado no dia procurado. Portanto, o usuário que obtivesse valores acima do desvio padrão, foi setado em uma lista de usuários suspeitos.

## Interface Gráfica
A nossa interface foi desenvolvida utilizado a biblioteca Swing do Java.
O Histograma foi desenvolvido usando o pacote JFreeChart.

## Problematicas
A criação do perfil dos usuários, assim como organizar a hierarquia de atividades executadas por todos foram a maior dificuldade encontrada por nós, a leitura dos arquivos por serem muito extensos foi redirecionada para apenas os arquivos sumarizados, uma vez que os dados são iguais (porém, completos). 

## Documentação
É possível acessar o Javadoc no arquivo ```index.html``` do projeto no diretório ```doc```. 

# Inicializar
java -jar ProjetoFinal_IT.jar

# Utilizar o sistema
Na interface do sistema o operador consegue obter uma lista de todos os usuários cadastrados atualmente, existe a opção de busca de um usuário pelo seu nome ou ID para análise do seu perfil e uma possível visualização do histograma (porém não está funcionando a opção na interface). E um botão para verificar as atividades anomalas do sistema, por meio da criação de um arquivo.


