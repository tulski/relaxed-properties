# 1

```text
# application.yaml
app-config:
  tenant-timezone: {}

# .env
APPCONFIG_TENANTTIMEZONE_PL=Europe/Warsaw
APPCONFIG_TENANTTIMEZONE_DE=Europe/Berlin

# run
./gradlew bootRun -Pdotenv.filename=.env.01 --args="--spring.config.location=application-01.yaml"

# outcome
AppConfig[tenantTimezone={pl=Europe/Warsaw, de=Europe/Berlin}]
```

# 2

```text
# application.yaml
app-config:
  tenant-timezone:
    EN: Europe/London
    DE: Europe/Berlin

# .env
APPCONFIG_TENANTTIMEZONE_PL=Europe/Warsaw

# run
./gradlew bootRun -Pdotenv.filename=.env.02 --args="--spring.config.location=application-02.yaml"

# outcome
AppConfig[tenantTimezone={pl=Europe/Warsaw, EN=Europe/London, DE=Europe/Berlin}]
```

# 3

```text
# application.yaml
app-config:
  tenant-timezone:
    EN: Europe/London
    DE: Europe/Berlin

# .env
APPCONFIG_TENANTTIMEZONE_EN=America/New_York
APPCONFIG_TENANTTIMEZONE_PL=Europe/Warsaw

# run
./gradlew bootRun -Pdotenv.filename=.env.03 --args="--spring.config.location=application-03.yaml"

# outcome
AppConfig[tenantTimezone={pl=Europe/Warsaw, en=America/New_York, EN=America/New_York, DE=Europe/Berlin}]
```

# 4

```text
# application.yaml
app-config:
  tenant-timezone:
    EN: America/New_York
    En: America/New_York
    eN: America/New_York
    E-N: America/New_York
    e-n: America/New_York

# .env
APPCONFIG_TENANTTIMEZONE_EN=Europe/London

# run
./gradlew bootRun -Pdotenv.filename=.env.04 --args="--spring.config.location=application-04.yaml"

# outcome
AppConfig[tenantTimezone={en=Europe/London, EN=Europe/London, En=Europe/London, eN=Europe/London, E-N=Europe/London, e-n=Europe/London}]
```

# 5 same with properties

```text
# application.yaml
app-config:
  tenant-timezone:
    EN: America/New_York
    En: America/New_York
    eN: America/New_York
    E-N: America/New_York
    e-n: America/New_York

# run
./gradlew bootRun --args="--spring.config.location=application-04.yaml -Dappconfig.tenanttimezone=Europe/London" 

# outcome
AppConfig[tenantTimezone={EN=America/New_York, En=America/New_York, eN=America/New_York, E-N=America/New_York, e-n=America/New_York}]
```