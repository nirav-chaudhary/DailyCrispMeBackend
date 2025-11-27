package com.example.dailycrispme.config;

import com.example.dailycrispme.model.Article;
import com.example.dailycrispme.model.Author;
import com.example.dailycrispme.model.Category;
import com.example.dailycrispme.service.InMemoryArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

        private final InMemoryArticleService articleService;

        public DataInitializer(InMemoryArticleService articleService) {
                this.articleService = articleService;
        }

        @Override
        public void run(String... args) throws Exception {
                // Categories
                Category news = new Category(1L, "News", "#1976D2");
                Category tech = new Category(2L, "Technology", "#388E3C");
                Category finance = new Category(3L, "Finance", "#D32F2F");
                Category environment = new Category(4L, "Environment", "#4CAF50");
                Category design = new Category(5L, "Design", "#FF9800");

                // Authors
                Author janeSmith = new Author("Jane Smith", "https://cdn.dailycrisp.me/jane.jpg");
                Author johnDoe = new Author("John Doe", "https://cdn.dailycrisp.me/john.jpg");
                Author peterJones = new Author("Peter Jones", "https://cdn.dailycrisp.me/peter.jpg");
                Author sarahChen = new Author("Sarah Chen", "https://cdn.dailycrisp.me/sarah.jpg");

                // Articles
                Article article1 = new Article(
                                "101",
                                "blockchain-beyond-cryptocurrency",
                                "Blockchain: Beyond Cryptocurrency",
                                "Understanding the potential...",
                                finance,
                                "Understanding the potential of blockchain technology...",
                                "<p>Blockchain technology has emerged as one of the most disruptive forces in the digital age, promising to redefine how we transact, share data, and establish trust. Originally devised for the digital currency Bitcoin, the tech community has now found other potential uses for the technology.</p>\n"
                                                +
                                                "\n" +
                                                "<h2>What is Blockchain?</h2>\n" +
                                                "<p>At its core, a blockchain is a decentralized, distributed ledger that records the provenance of a digital asset. By inherent design, the data on a blockchain is unable to be modified, which makes it a legitimate disruptor for industries like payments, cybersecurity, and healthcare.</p>\n"
                                                +
                                                "\n" +
                                                "<h2>Key Features</h2>\n" +
                                                "<ul>\n" +
                                                "  <li><strong>Decentralization:</strong> Unlike traditional databases managed by a central authority, blockchain is distributed across a network of computers.</li>\n"
                                                +
                                                "  <li><strong>Transparency:</strong> All transactions are viewable by participants with permission, creating a transparent audit trail.</li>\n"
                                                +
                                                "  <li><strong>Immutability:</strong> Once a transaction is recorded, it cannot be altered or deleted, ensuring data integrity.</li>\n"
                                                +
                                                "</ul>\n" +
                                                "\n" +
                                                "<h2>Beyond Cryptocurrency</h2>\n" +
                                                "<p>While Bitcoin is the most well-known application, blockchain's potential extends far beyond finance. Smart contracts, for instance, can automate complex agreements without intermediaries. Supply chain management can benefit from real-time tracking of goods, reducing fraud and errors.</p>\n"
                                                +
                                                "\n" +
                                                "<blockquote>\"The blockchain is an incorruptible digital ledger of economic transactions that can be programmed to record not just financial transactions but virtually everything of value.\" – Don & Alex Tapscott</blockquote>\n"
                                                +
                                                "\n" +
                                                "<h2>The Future Outlook</h2>\n" +
                                                "<p>As the technology matures, we can expect to see widespread adoption across various sectors. However, challenges such as scalability, energy consumption, and regulatory uncertainty remain. Overcoming these hurdles will be key to unlocking blockchain's full potential.</p>",
                                "2023-10-24T10:00:00Z",
                                "https://cdn.dailycrisp.me/ai_impact.png",
                                "https://cdn.dailycrisp.me/ai_impact.png",
                                janeSmith);
                articleService.addArticle(article1);

                Article article2 = new Article(
                                "102",
                                "the-rise-of-serverless",
                                "The Rise of Serverless Architectures",
                                "Exploring the benefits...",
                                tech,
                                "Exploring the benefits and challenges of serverless...",
                                "<p>Full HTML content...</p>",
                                "1 day ago",
                                "https://cdn.dailycrisp.me/ai_impact.png",
                                "https://cdn.dailycrisp.me/ai_impact.png",
                                johnDoe);
                articleService.addArticle(article2);

                Article article3 = new Article(
                                "103",
                                "sustainable-urban-planning",
                                "Sustainable Urban Planning",
                                "Innovations in creating...",
                                environment,
                                "Innovations in creating eco-friendly urban spaces...",
                                "<p>Full HTML content...</p>",
                                "4 days ago",
                                "https://cdn.dailycrisp.me/ai_impact.png",
                                "https://cdn.dailycrisp.me/ai_impact.png",
                                peterJones);
                articleService.addArticle(article3);

                Article article4 = new Article(
                                "104",
                                "future-of-ai-design",
                                "The Future of AI in Modern Interface Design",
                                "How artificial intelligence...",
                                design,
                                "How artificial intelligence is reshaping...",
                                "<p>Full HTML content...</p>",
                                "2 hours ago",
                                "https://cdn.dailycrisp.me/ai_impact.png",
                                "https://cdn.dailycrisp.me/ai_impact.png",
                                sarahChen);
                articleService.addArticle(article4);
        }
}