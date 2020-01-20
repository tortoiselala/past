package com.tortoise.dbtool;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyangmin
 * @date 2020/1/13
 */
public class Main {
    public static void main(String[] args) {
        // 执行中的异常信息会保存在warnings中
        List<String> warnings = new ArrayList<String>();
        try {
            // true:生成的文件覆盖之前的
            boolean overwrite = true;
            // 读取配置,构造 Configuration 对象.
            // 如果不想使用配置文件的话,也可以直接来 new Configuration(),然后给相应属性赋值.
            ClassPathResource resource = new ClassPathResource("generatorConfig.xml");
            File configFile = resource.getFile();
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (SQLException | IOException | InterruptedException | InvalidConfigurationException | XMLParserException e) {
            e.printStackTrace();
        }

        for (String warning : warnings){
            System.out.println(warning);
        }
    }
}
