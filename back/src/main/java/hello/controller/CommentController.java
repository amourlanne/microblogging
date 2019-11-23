package hello.controller;

import hello.ResourceNotFoundException;
import hello.model.Comment;
import hello.Repository.CommentRepository;
import hello.Repository.PostRepository;
import hello.model.Posts;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="/api")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository mainRepository;

    @GetMapping(path="/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getAllCommentsByPostId(@PathVariable (value = "postId") Long postsId) {
        List<Comment> comments = commentRepository.findAllByPostsId(postsId);
        return ResponseEntity.ok(comments);
    }

    /*
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Comment> createComment (@PathVariable (value = "postId") Long postId, @Valid @RequestBody Comment comment) {
        Posts post = mainRepository.findById(postId).orElse(null);
        if(post!= null) {
            return ResponseEntity.ok(commentRepository.save(comment));
        }
        return null;
    }*/

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable (value = "postId") Long postId,
                                 @Valid @RequestBody Comment comment) {
        return mainRepository.findById(postId).map(post -> {
            comment.setPosts(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

}

