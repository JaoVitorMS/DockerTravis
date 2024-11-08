# Baseado na imagem oficial do Jenkins Blue Ocean
FROM jenkins/jenkins:2.414.2

# Configuração adicional (caso necessária) pode ser feita aqui
USER root

# Instalações ou configurações extras podem ser adicionadas aqui
# Exemplo: RUN apt-get update && apt-get install -y <algum-pacote>

USER jenkins
