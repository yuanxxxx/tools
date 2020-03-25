package com.yuan;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2020/3/25 11:03
 */
public class Generator {

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<>();

        boolean overwritten = true;

        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration configuration = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwritten);

        MyBatisGenerator generator = new MyBatisGenerator(configuration, callback, warnings);
        generator.generate(null);

        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
