package hello.Repository;

import hello.model.Comment;
import hello.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    ArrayList<Comment> findAllByPostsId(Long postsId);

}
