package blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void should_add_a_new_comment_to_an_article_with_no_comments() throws CommentAlreadyExistException {
        var text = "Amazing article !!!";
        var author = "Pablo Escobar";

        article.addComment(text, author, TODAY);

        assertThat(article.getComments())
                .hasSize(1)
                .first()
                .extracting(Comment::author, Comment::text, Comment::creationDate)
                .containsExactly(author, text, TODAY);
    }

    @Test
    void should_add_a_comment_with_the_date_of_the_day() throws CommentAlreadyExistException {
        article.addComment("Amazing article !!!", "Pablo Escobar", TODAY);

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.creationDate().equals(TODAY));
    }

    @Test
    void should_throw_an_exception_when_adding_existing_comment() throws CommentAlreadyExistException {
        article.addComment("Amazing article !!!", "Pablo Escobar", TODAY);

        assertThatThrownBy(() -> article.addComment("Amazing article !!!", "Pablo Escobar", TODAY))
                .isInstanceOf(CommentAlreadyExistException.class);
    }
}
