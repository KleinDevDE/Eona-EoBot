rm EoBot-latest.jar
set version=EoBot-*
set version=%version:EoBot-=%
set version=%version:-jar-with-dependencies.jar=%
mkdir $version
rename EoBot-* EoBot-latest.jar
copy EoBot-latest.jar $version/EoBot-$version.jar