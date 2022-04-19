package aps.financemanagerapi.domain.entry.controller;

import aps.financemanagerapi.core.dto.ResponseDTO;
import aps.financemanagerapi.domain.entry.dto.ImportDTO;
import aps.financemanagerapi.domain.entry.service.ImporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/entries/import")
@RequiredArgsConstructor
public class ImporterController{
    private final ImporterService importerService;

    public ResponseEntity<Integer> importData(@RequestParam final MultipartFile file){
        importerService.setMultipartFile(file);
        final ResponseDTO<ImportDTO> responseDTO = importerService.execute();
        return ResponseEntity.ok(responseDTO.getDataSet().size());
    }
}