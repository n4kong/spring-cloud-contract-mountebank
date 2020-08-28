package com.demo;

import org.springframework.cloud.contract.spec.Contract;
import org.springframework.cloud.contract.verifier.converter.StubGenerator;
import org.springframework.cloud.contract.verifier.file.ContractMetadata;

import java.util.HashMap;
import java.util.Map;

public class CustomConverter implements StubGenerator {
    @Override
    public boolean canHandleFileName(String fileName) {
        return true;
    }

    @Override
    public Map<Contract, String> convertContents(String rootName, ContractMetadata content) {
        Map map = new HashMap<Contract,String>();
        content.getConvertedContract().stream().forEach(c -> {
            map.put(c, "This is Dummy " + c.getName());
        });
        return map;
    }

    @Override
    public String generateOutputFileNameForInput(String inputFileName) {
        return inputFileName;
    }

    @Override
    public String fileExtension() {
        return ".ejs";
    }
}
