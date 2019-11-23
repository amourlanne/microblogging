package hello.controller;

import hello.Repository.PostRepository;
import hello.Service.PostService;
import hello.model.Posts;
import hello.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="/api")
public class PostController {

    @Autowired
    private PostRepository mainRepository;

    @Autowired
    private PostService mainService;

    @GetMapping(path="/posts")
    public ResponseEntity<List<Posts>> getAllPosts() {
        // This returns a JSON or XML with the users
         return ResponseEntity.ok(mainService.findAll());
    }

    @PostMapping(path = "/posts")
    public @ResponseBody String addNewPost(@RequestBody Posts post) {
        mainService.savePosts(post);
        return "Saved";
    }

    @PutMapping("/posts/{postId}")
    public Posts updatePost(@PathVariable Long postId, @Valid @RequestBody Posts postRequest) {
        return mainRepository.findById(postId).map(posts -> {
            posts.setName(postRequest.getName());
            posts.setContent(postRequest.getContent());
            return mainRepository.save(posts);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }


    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost (@PathVariable Long postId) {
        return mainRepository.findById(postId).map(posts -> {
            mainRepository.delete(posts);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId" + postId + "not found"));
    }

}

