package fintech.controllers;

import fintech.data.impl.exceptions.GetRepositoryException;
import fintech.services.impl.DataService;
import fintech.services.impl.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/api/v1")
public class AdminController {
    private final DataService dataService;

    @Autowired
    public AdminController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> getClientById(@PathVariable("id") Integer clientId) throws GetRepositoryException, NotFoundException {
        return ResponseEntity.ok(dataService.getClientById(clientId));
    }
    @GetMapping("/client/{ip}")
    public ResponseEntity<?> getClientByIp(@PathVariable("ip") String ip) throws GetRepositoryException, NotFoundException {
        return ResponseEntity.ok(dataService.getClientByIp(ip));
    }
    @GetMapping("/translation/{id}")
    public  ResponseEntity<?> getTranslationsById(@PathVariable("id") Integer id) throws NotFoundException, GetRepositoryException {
        return ResponseEntity.ok(dataService.getTranslationById(id));
    }
}
