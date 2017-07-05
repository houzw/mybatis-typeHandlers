# mybatis-typeHandlers
>http://www.mybatis.org/mybatis-3/zh/configuration.html#typeHandlers

some mybatis TypeHandlers

## typeHandlers' configuration in mybatis.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <!--开启二级缓存-->
        <setting name="cacheEnabled" value="true"/>
        <setting name="logImpl" value="LOG4J"/>
    </settings>
    <typeAliases>
        <typeAlias alias="inetTypeHandler" type="org.egc.cybersolim.mybatis.InetTypeHandler" />
    </typeAliases>
    <typeHandlers>
        <typeHandler jdbcType="OTHER" handler="org.egc.cybersolim.mybatis.InetTypeHandler"/>
    </typeHandlers>
</configuration>
```
