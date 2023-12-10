package blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.BDDAssertions.catchException;
import static org.assertj.core.api.BDDAssertions.then;

class ArticleTests {

    private final LocalDate TODAY = LocalDate.of(2023, 12, 4);
    private Article article;

    @BeforeEach
    void setUp() {
        article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
    }

    @Test
    void should_add_new_comment_to_article_with_no_comments() throws CommentAlreadyExistException {
        var text = "Amazing article !!!";
        var author = "Pablo Escobar";

        article.addComment(text, author, TODAY);

        then(article.getComments())
                .hasSize(1)
                .first()
                .extracting(Comment::author, Comment::text, Comment::creationDate)
                .containsExactly(author, text, TODAY);
    }

    @Test
    void should_add_new_comment_to_article_with_existing_comment() throws CommentAlreadyExistException {
        var text = "Amazing article !!!";
        var author = "Pablo Escobar";
        article.addComment("any text", "any author", LocalDate.now());

        article.addComment(text, author, TODAY);

        then(article.getComments())
                .hasSize(2)
                .last()
                .extracting(Comment::author, Comment::text, Comment::creationDate)
                .containsExactly(author, text, TODAY);
    }

    @Test
    void should_fail_to_add_the_same_comment_twice() throws CommentAlreadyExistException {
        String text = "Amazing article !!!";
        String author = "Pablo Escobar";
        article.addComment(text, author, TODAY);

        Exception exception = catchException(() -> article.addComment(text, author, TODAY));

        then(exception)
                .isInstanceOf(CommentAlreadyExistException.class);
    }
}
