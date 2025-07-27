# Этап сборки (Builder)
FROM gradle:8.13.0-jdk21

WORKDIR .

COPY . .

RUN gradle installDist

CMD ./build/install/app/bin/app