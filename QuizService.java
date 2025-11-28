package com.aiquiz.quiz.service;

import com.aiquiz.quiz.model.Question;
import com.aiquiz.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository repository;

    public List<Question> listar() {
        return repository.findAll();
    }

    public Question salvar(Question q) {
        return repository.save(q);
    }

    public Optional<Question> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
