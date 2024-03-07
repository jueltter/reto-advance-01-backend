# reto-advance-01-backend

reto-advance-01-backend es el backend del ejercicio planteado. Utiliza el framework Spring y cuenta con dos endpoints: vehiculos y restricciones.

## Prerequisitos
1. Tener instalado java 17
2. Tener instalado maven compatible con java 17
3. Tener instalado git

## Despliegue y Ejecución

```bash
# clonar el repositorio
git clone https://github.com/jueltter/reto-advance-01-backend.git
# cambiarse a la rama master
git checkout master
# acceder a la carpeta del proyecto
cd ./reto-advance-01-backend
# generar archivo jar, se puede ejecutar tambien el wrapper ./mvnw clean package
mvn clean package
# ejecutar jar
java -jar ./target/*.jar

```
Acceder a [http://localhost:8081/vehiculos](http://localhost:8081/vehiculos).

## Uso

1. [Revisar Documentación](https://documenter.getpostman.com/view/12442172/2sA2xfYDms).

## Licencia

N/A