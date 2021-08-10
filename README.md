# Nimble-api

Nimble-api é o software de gestão comercial... 

## Projeto
Exemplo: projeto contém características de estrutura parecidas com as do
projeto da Gumga, sendo composto pelos seguintes pacotes:

- mobiage-api
    - finance-api
    - finance-application
    - finance-domain
    - manager-api
    - manager-application
    - manager-domain
    - mobiage-boot
    - mobiage-configuration
    - mobiage-gateway
    - mobiage-integration
    - mobiage-sgpdv
    - release-notes
****

## Docker
O Docker possibilita o empacotamento de uma aplicação ou ambiente
inteiro dentro de um container, e a partir desse momento o ambiente
inteiro torna-se portável para qualquer outro Host que contenha o Docker
instalado.
Isso reduz drasticamente o tempo de deploy de alguma infraestrutura ou até mesmo aplicação, pois não há necessidade de ajustes de ambiente para o correto funcionamento do serviço, o ambiente é sempre o mesmo, configure-o uma vez e replique-o quantas vezes quiser.

[Referência e mais informações](https://www.mundodocker.com.br/o-que-e-docker/)

Algumas vantagens em utilizar docker:
- Padronização - “No meu PC ta funcionando”. O ambiente será sempre o mesmo, seja na máquina do programador backend, programador frontend, do tester ou no servidor. A imagem é sempre a mesma.
- Facilidade de subir a aplicação. Não é necessário intellij, postgres, etc. Só é necessário dar um comando e o docker faz o resto.
- Foco no objetivo e não no ambiente. Por que um frontend se preocuparia em rodar o back ou em usar o homologação? Nem sempre o homologação está funcionando.

### Subindo com o docker
#### Requisitos:
- docker-ce
- docker-compose

#### Comandos de instalação
```shell script
# Removendo imagens antigas
sudo apt-get remove docker docker-engine docker.io containerd runc
# Limpando e atualizando cache/índices de instalação do apt 
sudo apt-get update
# Instalando pacotes que permitam que o apt use repositorios HTTPS
sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common
# Adicionando as chaves GPG oficiais do Docker
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
# Adicionando o último repositório estável
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
# Limpando e atualizando cache/índices de instalação do apt 
sudo apt-get update
# Instalando a última versão do Docker 
sudo apt-get install docker-ce docker-ce-cli containerd.io
# Criando o grupo de usuário 'docker'
sudo groupadd docker
# Adicionando o usuário atual no grupo, dessa forma não precisa executar os comandos docker com sudo
sudo usermod -aG docker $USER
# Baixando a versão estável mais recente do Docker Compose
sudo curl -L "https://github.com/docker/compose/releases/download/1.25.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
# Aplicando as permissões para instalação do arquivo binário baixado
sudo chmod +x /usr/local/bin/docker-compose
```

**Obs: _Já existe um arquivo docker-compose.yml dentro do projeto, na
pasta docker, caso ainda seja uma jovem padawan, peça ajuda para apontar
os IP's e portas corretamente e nunca mais use a frase: "na minha
máquina funciona"._**

## Trabalhando com imagens
Se você fizer alguma alteração na API, deverá buildar a imagem para as alterações surtirem efeito.

Execute os seguintes comandos:
```
mvn clean install -Dmaven.test.skip=true
mvn clean package dockerfile:build
```
Uma nova imagem será gerada e você poderá subir os containers para testar suas alterações.

#### Upload da imagem no docker-hub

Link: https://hub.docker.com/r/mobiagelabs/


O seguinte comando irá buildar a api e atualiza-la no hub:
```
mvn clean package dockerfile:build dockerfile:push
```


## Comandos que podem ser úteis
#### Listando todas as imagens
```
docker images
```

#### Listando containers em execução
```
docker ps
```

#### Listando todos os containers
```
docker ps -a
```

#### Parando um container
```
docker stop <id>
```

#### Removendo um container
```
docker rm <id>
```

#### Parando e removendo todos os containers
```
docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q)
```

#### removendo todas as imagens
```
docker rmi $(docker image ls -q)
```
************
## Properties
A API não usa mais um arquivo .properties localizado na pasta
gumgaFiles. Foi implementado spring-cloud-config. Indique na execução do
projeto o active profile (-Dspring.profiles.active=development) que você
necessita rodar a aplicação. As profiles se encontram [neste
repositório](https://github.com/mobiagelabs/storage-configuration/tree/master/microservices-configuration)

Cada arquivo é destinado para um profile diferente. Este repositório
contém também configurações de outros projetos em **produção**, portanto
**tome cuidado ao fazer alterações.**

************

## GraphQL
Esta é uma ferramenta que é possívelmente um futuro uso da mobiage, por
isso deixaremos aqui um breve comentário sobre ele.

GraphQL é uma linguagem de consulta criada pelo Facebook em 2012 e
lançada publicamente em 2015. É considerada uma alternativa para
arquiteturas REST, além de oferecer um serviço runtime para rodar
comandos e consumir uma API. [Site oficial](https://graphql.org/)

Em nosso docker-compose.yml dentro do projeto, já existe o container do
Hasura, e lá você pode iniciar as brincadeiras como esta linguagem de
consulta.

## JIRA

O Jira é o Software qual optamos como ferramenta de gerenciamento ágil
de nossos projetos ágeis. Nele contém os painéis em que planejamos,
acompanhamos e gerenciamos todos os projetos de desenvolvimento ágil. O
Jira está integrado ao GitHub e existe um padrão de commit para que
possamos automatizar o fluxo da tarefa.

Exemplo de commit:
```
MOB-1000 #Resolvido #time 1h 10m 30s #comment Atualizado tabela de preços
# MOB-1000 (Inicia-se sempre pelo número da tarefa ao qual o commit foi dedicado)
# #Resolvido (Indica o status em que a tarefa deve ser direcionada)
# #time 1h 10m 30s (Indica o tempo que foi usado para executar a tarefa até o momento do commit)
# #comment Atualizado tabela de preços (Indica o comentário do que foi feito e este comentário aparecerá como comentário da tarefa)
```

Procurem adotar este padrão de commit e veja o quanto isso deixará a
equipe mais organizada! Quando tiver dúvidas do que foi feito em certa
tarefa, ao abrir ela no Jira, os commits referentes àquela tarefa estará
toda rastreada e pode até facilitar nas reuniões da Sprint.

## Padrões do projeto

## Integrações

#### GetCard POS-TEF
Documentação pendente!
#### SPC/SERASA
Documentação pendente!
#### PagarMe
Documentação pendente!
#### Z-API
Documentação pendente!
#### SG PDV
Documentação pendente!
#### MobiTools
Documentação pendente!

## Rancher CLI

O Rancher CLI (Command Line Interface) é uma ferramenta unificada que
usamos para interagir com o Rancher. Com esta ferramenta, podemos operar
o rancher usando o terminal de comando ao invés da GUI. Usamos o rancher
CLI como a ferramenta mais fácil de extrair um backup de banco de dados.
Após a instalação e configuração do Rancher CLI [(Confira a documentação
aqui)](https://rancher.com/docs/rancher/v2.x/en/cli/) os comandos abaixo
te ajudarão a entender como fazer backups, baixar os backups ou subir
arquivos.

Lembre-se que Rancher é um gerenciador de clusters do Kubernetes, nos
fornece ferramentas integradas para executar cargas de trabalho em
containers. Sendo assim é mais do que fundamental que você saiba
plenamente o que é
[Docker](https://terminalroot.com.br/2019/08/tutorial-definitivo-de-docker-para-iniciantes-ubuntu.html)
e
[Kubernetes](https://blog.geekhunter.com.br/kubernetes-a-arquitetura-de-um-cluster/),
talvez esse
[canal](https://www.youtube.com/watch?v=pV0nkr61XP8&list=PLf-O3X2-mxDmXQU-mJVgeaSL7Rtejvv0S)
possa te ajudar.

Então vamos para os comandos (crie um alias para o comando ./rancher, no
exemplo o meu alias foi definido como 'rancher'):
```shell script
# Para trocar  o contexto ("ambiente")
rancher context switch
# vamos listar os pods
rancher kubectl get pods --all-namespaces
# Vamos acessar o pod database e executar o bash
rancher kubectl -n database exec -it database-mobiage-0 bash
# Vamos então executar a transferencia de um arquivo de dentro do container pro nosso computador
rancher kubectl -n database cp database-mobiage-0:/path/file.ext ~/Documents/file.ext
```
