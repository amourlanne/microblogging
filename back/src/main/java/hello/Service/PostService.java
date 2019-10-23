package hello.Service;

import hello.Repository.PostRepository;
import hello.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository mainRepository;

    public List<Posts> findAll() {
        return  mainRepository.findAll();
    }


    public Posts savePosts(Posts posts) {
        if(posts.getCreationDate() == null) {
            posts.setCreationDate(new Date());
        }
        return mainRepository.save(posts);
    }

}
