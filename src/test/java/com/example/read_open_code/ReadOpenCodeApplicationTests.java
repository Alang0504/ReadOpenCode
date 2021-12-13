package com.example.read_open_code;

import com.example.read_open_code.generator.GeneratorCodeConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReadOpenCodeApplicationTests {

    String[] tables = new String[]{"test_table_one", "test_table_two"};

    @Test
    void contextLoads() {
        GeneratorCodeConfig generatorCodeConfig = new GeneratorCodeConfig();
        generatorCodeConfig.executeGenerator(tables);
    }

}
