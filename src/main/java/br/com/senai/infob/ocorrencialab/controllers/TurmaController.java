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

import br.com.senai.infob.ocorrencialab.models.Turma;
import br.com.senai.infob.ocorrencialab.services.TurmaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @DeleteMapping("/delete/{id}") 
    public String deletar(@PathVariable Integer id) {
        boolean deletou =  turmaService.delete(id);
        if (deletou) {
            return "Usuário removido com sucesso";
        }
        return "Falha ao remover o usuário";
        }

         @GetMapping("/listar")
        public List<Turma> listarTodos() {
            return turmaService.listartodos();
        }
        
    @PostMapping("/salvar")
    public Turma salvar (@RequestBody Turma turma) {    
        return turmaService.salvar(turma);
    }


    @PutMapping("/atualizar/{id}")
        public Turma atualizaroTurma(@PathVariable Integer id, @RequestBody Turma turma ) {
            return turmaService.atualizarTurma(turma, id);
    }
    @GetMapping("/buscar/{id}")
    public Turma buscar (@PathVariable Integer id) {
    return turmaService.getId(id);
}
}
