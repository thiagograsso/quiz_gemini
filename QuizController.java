package com.aiquiz.quiz.controller;

import com.aiquiz.quiz.model.Question;
import com.aiquiz.quiz.service.AiQuizService;
import com.aiquiz.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private AiQuizService aiService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("questions", quizService.listar());
        return "index";
    }

    @GetMapping("/criar")
    public String criarPergunta(Model model) {
        model.addAttribute("question", new Question());
        return "criar";
    }

    @PostMapping("/criar")
    public String salvarPergunta(@ModelAttribute Question question) {
        quizService.salvar(question);
        return "redirect:/";
    }

    @PostMapping("/gerar")
    public String gerarPelaIa(@RequestParam String tema, Model model) {
        String resposta = aiService.gerarPergunta(tema);
        model.addAttribute("gerado", resposta);
        return "gerado";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        model.addAttribute("question", quizService.buscarPorId(id).orElse(null));
        return "detalhes";
    }
}
