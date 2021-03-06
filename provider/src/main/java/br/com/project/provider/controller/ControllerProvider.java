package br.com.project.provider.controller;


import br.com.project.provider.controller.dto.ProviderInfoDTO;
import br.com.project.provider.mapper.ProviderMapper;
import br.com.project.provider.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/info")
public class ControllerProvider {

    private final ProviderService providerService;

    private final ProviderMapper mapper;

    private static final Logger LOG = LoggerFactory.getLogger(ControllerProvider.class);

    @GetMapping(value = "/{state}")
    public ResponseEntity<ProviderInfoDTO> getProviderInfoByState(@PathVariable String state) {

        LOG.info("Recebido pedido de informações do fornecedor de {}", state);
        return ResponseEntity.ok(mapper.toDTO(providerService.getInfoByState(state)));

    }
}
