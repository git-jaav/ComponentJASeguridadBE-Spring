###AUTO BUILD COMPONENTES ####
#### ./autoBuildInit.sh  OR sh autoBuildInit.sh OR bash autoBuildInit.sh

echo "********************************************"
echo "***INICIANDO BASH ****"

cd ModelSeguridadGeneral
mvn clean install

cd .. && cd RepositorySeguridadGeneral
mvn clean install

cd .. && cd ServiceGeneral
mvn clean install


echo "***FIN BASH ****"
echo "********************************************"
