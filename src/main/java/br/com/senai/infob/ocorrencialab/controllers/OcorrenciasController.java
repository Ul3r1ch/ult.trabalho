package br.com.senai.infob.ocorrencialab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.infob.ocorrencialab.models.Ocorrencias;
import br.com.senai.infob.ocorrencialab.services.OcorreciasService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciasController {
    
    @Autowired
    private OcorreciasService ocorrenciasService;

    @DeleteMapping("/delete/{id}") 
    public String deletar(@PathVariable Integer id) {
        boolean deletou =  ocorrenciasService.delete(id);
        if (deletou) {
            return "Usuário removido com sucesso";
        }
        return "Falha ao remover o usuário";
        }

         @GetMapping("/listar")
        public List<Ocorrencias> listarTodos() {
            return ocorrenciasService.listartodos();
        }
        
    @PostMapping("/salvar")
    public Ocorrencias salvar (@RequestBody Ocorrencias ocorrencias) {    
        return ocorrenciasService.salvar(ocorrencias);
    }


    @PutMapping("/atualizar/{id}")
        public Ocorrencias atualizaroOcorrencias(@PathVariable Integer id, @RequestBody Ocorrencias ocorrencias ) {
            return ocorrenciasService.atualizarOcorrencias(ocorrencias, id);
    }
    @GetMapping("/buscar/{id}")
    public Ocorrencias buscar (@PathVariable Integer id) {
    return ocorrenciasService.getId(id);
}
}
