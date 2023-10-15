package com.bcopstein.endpointsdemo1.Interface;



import java.util.List;

import org.springframework.*;

@RestController
@RequestMapping("/orcamentos")
public class CalculoFreteController {

    @Autowired
    public CalculoFreteController() {
       
    }

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String getSaudacao() {
        return "Bem vindo a biblioteca!";
    }

    @GetMapping("/livros")
    @CrossOrigin(origins = "*")
    public List<String> getLivros() {
        return null;
    }

    @GetMapping("/tituloAutor")
    @CrossOrigin(origins = "*")
    public List<String> getAutor(@RequestParam(value = "autor") String autor) {
        return null;
    }

    @GetMapping("/removeLivro")
    @CrossOrigin(origins = "*")
    public Boolean removeLivro(@RequestParam(value = "codigo") int codigo) {
        return true;
    }

    @GetMapping("/autoresAno")
    @CrossOrigin(origins = "*")
    public List<String> getAno(@RequestParam(value = "ano") int ano) {
        return null;
    }

    @GetMapping("/desatualizados")
    @CrossOrigin(origins = "*")
    public List<String> getDesatualizadoAno(@RequestParam(value = "ano") int ano) {
        return null;
    }

    @GetMapping("/getId")
    @CrossOrigin(origins = "*")
    public String getPorId(@RequestParam(value = "id") int id) {
        return "";
    }

    @GetMapping("/titulo")
    @CrossOrigin(origins = "*")
    public String getTitulo(@RequestParam(value = "titulo") String titulo) {
        return null;
    }

    @GetMapping("/obrasPorAutor")
    @CrossOrigin(origins = "*")
    public int obrasAutor(@RequestParam(value = "autor") String autor) {
        return 5;
    }

    @GetMapping("/atualizadosAno")
    @CrossOrigin(origins = "*")
    public int atualizadosAno(@RequestParam(value = "ano") int ano) {
        return 5;
    }

    @GetMapping("/mediaObrasAutor")
    @CrossOrigin(origins = "*")
    public double mediaObrasAutor(@RequestParam(value = "autor") String autor) {
        return 2;
    }
}
