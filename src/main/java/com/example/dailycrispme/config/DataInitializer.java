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
                Author janeSmith = new Author("Jane Smith", "https://cdn.dailycrisp.me/female_avatar.avif");
                Author johnDoe = new Author("John Doe", "https://cdn.dailycrisp.me/male_avatar.avif");
                Author peterJones = new Author("Peter Jones", "https://cdn.dailycrisp.me/male_avatar.avif");
                Author sarahChen = new Author("Sarah Chen", "https://cdn.dailycrisp.me/female_avatar.avif");

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
                                "https://cdn.dailycrisp.me/blockchain.avif",
                                "https://cdn.dailycrisp.me/blockchain.avif",
                                janeSmith);
                articleService.addArticle(article1);

                Article article2 = new Article(
                                "102",
                                "the-rise-of-serverless",
                                "The Rise of Serverless Architectures",
                                "Exploring the benefits...",
                                tech,
                                "Exploring the benefits and challenges of serverless...",
                                "<p>Serverless architectures have rapidly moved from niche experimentation to mainstream application design, reshaping how teams build, deploy, and scale software. By abstracting away server management, serverless enables developers to focus on delivering value rather than provisioning infrastructure. What began as simple event-driven functions has evolved into a rich ecosystem of managed services, event buses, and edge runtimes that power everything from APIs to data pipelines and machine learning inference.</p>\n" +
                                        "\n" +
                                        "<h2>What is Serverless?</h2>\n" +
                                        "<p>At its core, serverless is a cloud execution model where the cloud provider dynamically manages the allocation and scaling of compute resources. Developers write functions or workloads that execute in response to events—HTTP requests, queue messages, file uploads, or scheduled triggers—without managing servers, VMs, or containers directly. Billing is typically based on actual usage (invocations, compute time, and resources consumed) rather than on pre-allocated capacity, aligning cost with value delivered.</p>\n" +
                                        "\n" +
                                        "<h2>Key Benefits</h2>\n" +
                                        "<ul>\n" +
                                        "  <li><strong>No Server Management:</strong> Operations overhead is reduced as the provider handles provisioning, patching, scaling, and high availability.</li>\n" +
                                        "  <li><strong>Auto-Scaling:</strong> Workloads scale up and down automatically to meet demand, including to zero when idle, improving efficiency.</li>\n" +
                                        "  <li><strong>Pay-Per-Use:</strong> Costs track real usage—invocations, duration, and memory—minimizing waste from idle resources.</li>\n" +
                                        "  <li><strong>Faster Time-to-Market:</strong> Teams iterate quickly by composing managed services (auth, databases, queues) with minimal boilerplate.</li>\n" +
                                        "  <li><strong>Global at the Edge:</strong> Edge functions and CDN-integrated runtimes enable low-latency, geo-distributed experiences by default.</li>\n" +
                                        "</ul>\n" +
                                        "\n" +
                                        "<h2>Beyond Functions-as-a-Service</h2>\n" +
                                        "<p>While Functions-as-a-Service (FaaS) is central, modern serverless extends far beyond single-purpose functions. Fully managed databases, event streaming, workflow orchestrators, and API gateways form a powerful fabric for event-driven systems. Patterns like CQRS, pub/sub, and saga orchestration are increasingly common, enabling resilient, decoupled services. Use cases span REST and GraphQL APIs, real-time notifications, data ingestion, ETL, IoT processing, and scheduled jobs—often stitched together with infrastructure-as-code and observability baked in.</p>\n" +
                                        "\n" +
                                        "<blockquote>“Serverless isn’t about servers going away; it’s about developers not having to think about them.” – Paraphrase of a common industry maxim</blockquote>\n" +
                                        "\n" +
                                        "<h2>Challenges and Trade-offs</h2>\n" +
                                        "<p>Despite its appeal, serverless introduces new considerations. Cold starts can impact latency-sensitive workloads, though provisioned concurrency and edge runtimes help. Observability across distributed events requires thoughtful tracing, logging, and metrics. Vendor lock-in, service quotas, and regional constraints can shape architecture choices. Certain long-running or highly specialized compute tasks may be more cost-effective on containers or VMs. Designing for idempotency, retries, and eventual consistency becomes essential in event-driven flows.</p>\n" +
                                        "\n" +
                                        "<h2>The Future Outlook</h2>\n" +
                                        "<p>As platforms mature, we can expect tighter integration between edge and core runtimes, improved developer experience through standardized tooling, and richer data and AI-native serverless services. Better portability via open standards and multi-cloud abstractions will reduce lock-in. For many workloads, serverless will increasingly become the default choice—combining operational simplicity, elastic scale, and cost alignment—freeing teams to focus on product impact rather than infrastructure plumbing.</p>",
                                "1 day ago",
                                "https://cdn.dailycrisp.me/serverless.avif",
                                "https://cdn.dailycrisp.me/serverless.avif",
                                johnDoe);
                articleService.addArticle(article2);

                Article article3 = new Article(
                                "103",
                                "sustainable-urban-planning",
                                "Sustainable Urban Planning",
                                "Innovations in creating...",
                                environment,
                                "Innovations in creating eco-friendly urban spaces...",
                                "<p>Sustainable urban planning has shifted from a niche concern to a central pillar of city-making, shaping how communities grow amid climate pressures, rapid urbanization, and evolving social needs. It integrates environmental stewardship, economic vitality, and social equity to create cities that are livable, resilient, and inclusive. From compact, walkable neighborhoods and renewable energy integration to transit-oriented development and nature-based solutions, the agenda seeks to tame sprawl, reduce emissions, and improve quality of life. As cities become home to the majority of the world’s population, sustainable planning provides a roadmap for balancing growth with ecological limits—ensuring that infrastructure, housing, mobility, and public space serve both present and future generations.</p>\n" +
                                        "\n" +
                                        "<h2>What is Sustainable Urban Planning?</h2>\n" +
                                        "<p>At its core, sustainable urban planning is an interdisciplinary approach to designing and managing urban areas so that environmental, social, and economic objectives reinforce one another. Planners coordinate land use, transportation, utilities, housing, and public amenities to minimize ecological impact while maximizing accessibility and opportunity. This involves compact mixed-use development, preservation of green and blue corridors, multimodal mobility options, and circular systems for energy, water, and waste. It also requires policy frameworks—zoning, building codes, pricing mechanisms, and performance standards—that align incentives with sustainability goals. Crucially, the process is participatory, engaging residents, community organizations, and private stakeholders to ensure that plans reflect local priorities and guard against displacement or inequitable outcomes.</p>\n" +
                                        "\n" +
                                        "<h2>Key Principles</h2>\n" +
                                        "<ul>\n" +
                                        "  <li><strong>Compact, Mixed-Use Development:</strong> Concentrate housing, jobs, services, and amenities within walkable districts to reduce car dependency and infrastructure costs.</li>\n" +
                                        "  <li><strong>Transit-Oriented and Active Mobility:</strong> Prioritize transit hubs, safe cycling networks, and pedestrian-friendly streets to enable low-carbon, healthy movement.</li>\n" +
                                        "  <li><strong>Green and Blue Infrastructure:</strong> Integrate parks, urban forests, wetlands, and permeable surfaces to enhance biodiversity, manage stormwater, and cool urban heat islands.</li>\n" +
                                        "  <li><strong>Resource Efficiency and Circularity:</strong> Promote energy-efficient buildings, district energy, water reuse, and waste-to-resource systems to reduce consumption and emissions.</li>\n" +
                                        "  <li><strong>Equity and Inclusion:</strong> Ensure access to affordable housing, transit, and services; prevent displacement; and address environmental burdens borne by marginalized communities.</li>\n" +
                                        "</ul>\n" +
                                        "\n" +
                                        "<h2>Planning Approaches and Tools</h2>\n" +
                                        "<p>Modern sustainable planning leverages a suite of strategies and digital tools. Scenario planning and spatial analytics help test land-use alternatives against greenhouse gas targets, habitat conservation, and affordability outcomes. Data from sensors and mobility platforms inform demand-responsive transit and efficient street design. Design guidance—like form-based codes—encourages human-scale, climate-adaptive architecture, while performance-based zoning links development approvals to outcomes such as energy intensity or open-space provision. Financing mechanisms, from green bonds to value capture, fund public realms and transit corridors.</p>\n" +
                                        "<ul>\n" +
                                        "  <li><strong>Transit-Oriented Development (TOD):</strong> Concentrates density near transit stations with limited parking, complete streets, and mixed-use programs.</li>\n" +
                                        "  <li><strong>15-Minute City:</strong> Designs neighborhoods where daily needs—work, education, health, recreation—are accessible within a short walk or bike ride.</li>\n" +
                                        "  <li><strong>Nature-Based Solutions:</strong> Employs bioswales, green roofs, and restored waterways to manage floods, store carbon, and enhance public space.</li>\n" +
                                        "  <li><strong>District Systems:</strong> Implements district heating/cooling, microgrids, and shared water infrastructure for efficiency and resilience.</li>\n" +
                                        "  <li><strong>Digital Twins and Analytics:</strong> Uses dynamic models to simulate energy, traffic, and climate risks, improving decisions and monitoring.</li>\n" +
                                        "</ul>\n" +
                                        "\n" +
                                        "<h2>Beyond “Green”: Social and Economic Dimensions</h2>\n" +
                                        "<p>Sustainability is inseparable from equity and prosperity. Policies must address housing affordability, access to jobs and education, and health disparities that often map onto historical redlining or industrial siting. Inclusionary zoning, community land trusts, and anti-displacement strategies can stabilize neighborhoods as they improve. Local economic development—supporting small businesses, creative industries, and green jobs—builds wealth close to where people live. Public spaces that are safe, inclusive, and culturally resonant foster social cohesion. When designed with community input, these interventions deliver benefits across generations and help legitimize long-term climate investments.</p>\n" +
                                        "\n" +
                                        "<h2>Global Illustrations</h2>\n" +
                                        "<p>Several cities showcase elements of sustainable planning. Copenhagen’s cycling-first design and district heating system demonstrate how mobility and energy policy can reinforce each other. Curitiba pioneered bus rapid transit integrated with land use, enabling affordable mobility and compact growth. Singapore’s water-sensitive urban design and sky-rise greenery mitigate heat and enhance livability in a dense, equatorial context. Medellín’s cable cars and escalators illustrate how transit investments can connect hillside communities to opportunities and public services. While contexts differ, the common thread is a coordinated, multi-sector strategy rooted in local needs and continuous iteration.</p>\n" +
                                        "\n" +
                                        "<h2>Challenges and Trade-offs</h2>\n" +
                                        "<p>Ambition runs into practical constraints. Land and construction costs can undermine affordability goals; strict environmental standards may inadvertently raise housing prices without complementary subsidies. Governance fragmentation across agencies and jurisdictions slows implementation, while short political cycles clash with long-term infrastructure timelines. Community opposition may emerge when projects are perceived as top-down or threatening to cultural identity. Technical hurdles include retrofitting legacy utilities, mitigating construction-related emissions, and maintaining reliable transit funding. Plans must anticipate climate uncertainty—heat waves, flooding, sea-level rise—and embed redundancy and flexible responses. Transparent trade-off analysis and sustained engagement are essential to maintain trust and momentum.</p>\n" +
                                        "\n" +
                                        "<h2>Measuring What Matters</h2>\n" +
                                        "<p>To ensure progress, cities are adopting clear metrics and open reporting. Carbon budgets align land-use and building decisions with net-zero pathways. Accessibility indicators measure reachability of jobs, schools, and services within specified travel times by mode. Public health metrics track air quality, heat exposure, and active travel. Housing indicators capture affordability, overcrowding, and displacement risk. Biodiversity and tree canopy measures reflect ecological health. Dashboards and public data portals enable accountability and empower community advocates to co-create solutions. Tying incentives and approvals to measurable performance helps shift focus from intentions to outcomes.</p>\n" +
                                        "\n" +
                                        "<blockquote>“A sustainable city is not merely one that emits less, but one that enables everyone to live well within planetary boundaries.”</blockquote>\n" +
                                        "\n" +
                                        "<h2>The Path Forward</h2>\n" +
                                        "<p>The next decade will see deeper integration of climate adaptation with mitigation, especially as extreme weather stresses infrastructure and public health. Expect more hybrid mobility systems blending mass transit with micromobility and on-demand services, all prioritized on safe, low-speed streets. Building codes will accelerate electrification and passive design, while district-scale strategies link renewables, storage, and demand management. Nature will be treated as infrastructure—budgeted, maintained, and expanded for performance. Crucially, equitable governance models will elevate community leadership, ensuring that investments in resilience also deliver affordability, safety, and cultural vitality. With pragmatic tools, sustained financing, and shared civic vision, sustainable urban planning can transform cities into places that are not only lower-carbon and climate-ready, but also humane, opportunity-rich, and inspiring.</p>",
                                "4 days ago",
                                "https://cdn.dailycrisp.me/urban_planning.avif",
                                "https://cdn.dailycrisp.me/urban_planning.avif",
                                peterJones);
                articleService.addArticle(article3);

                Article article4 = new Article(
                                "104",
                                "future-of-ai-design",
                                "The Future of AI in Modern Interface Design",
                                "How artificial intelligence...",
                                design,
                                "How artificial intelligence is reshaping...",
                                "<p>Artificial intelligence is rapidly transforming modern interface design, moving beyond static layouts and heuristics toward adaptive, anticipatory, and context-aware experiences. From generative design assistants and multimodal interactions to personalization engines and ethics-aware guardrails, AI is reframing how teams conceive, craft, and continuously improve user interfaces. Rather than replacing designers, AI is becoming an amplifier—accelerating iteration, revealing hidden user needs through data, and enabling interfaces that mold themselves to intent, environment, and ability. As models evolve and run more efficiently at the edge, the future of interface design looks increasingly real-time, collaborative, and human-centered by default.</p>\n" +
                                        "\n" +
                                        "<h2>What Is AI-Driven Interface Design?</h2>\n" +
                                        "<p>AI-driven interface design integrates machine learning and generative models into both the design workflow and the runtime behavior of products. In the workflow, models assist with ideation, layout proposals, content generation, accessibility checks, and usability testing at scale. In runtime, AI powers adaptive UI components, intelligent defaults, predictive flows, and multimodal interactions (text, voice, image, gesture). The goal is to reduce friction and cognitive load by aligning interfaces with user goals, context, and constraints—while preserving clarity, transparency, and user agency.</p>\n" +
                                        "\n" +
                                        "<h2>Key Capabilities Shaping the Future</h2>\n" +
                                        "<ul>\n" +
                                        "  <li><strong>Generative Design Systems:</strong> Models produce layout variants, microcopy, iconography, and visual themes based on briefed constraints, brand tokens, and accessibility rules.</li>\n" +
                                        "  <li><strong>Adaptive and Context-Aware UI:</strong> Interfaces reconfigure based on intent signals, device capability, network conditions, and user proficiency, surfacing the right controls at the right moment.</li>\n" +
                                        "  <li><strong>Multimodal Interaction:</strong> Combined text, voice, image, and gesture inputs expand accessibility and speed—especially for hands-free, small-screen, or expert workflows.</li>\n" +
                                        "  <li><strong>Predictive Guidance:</strong> Flow optimization, proactive suggestions, and intelligent defaults shorten paths to value while preserving clear undo/confirm controls.</li>\n" +
                                        "  <li><strong>Personalization at Scale:</strong> Real-time segmentation and on-device models tailor content density, tone, and feature exposure without compromising privacy.</li>\n" +
                                        "</ul>\n" +
                                        "\n" +
                                        "<h2>How AI Changes the Design Workflow</h2>\n" +
                                        "<p>Designers are evolving from pixel producers to system choreographers. AI copilots can translate problem statements into wireframe options, generate component variants in design tools, and propose content alternatives aligned with style guides. Usability research benefits from synthetic users and automated heuristics that flag friction points. Continuous delivery pipelines integrate AI-driven experimentation—automatically proposing A/B candidates and analyzing multi-metric outcomes. Crucially, teams establish design guardrails: design tokens, motion principles, and accessibility standards that models must respect. This shifts the craft toward curating constraints, articulating intent, and reviewing AI output with a critical, ethical lens.</p>\n" +
                                        "\n" +
                                        "<h2>Patterns for AI-Native Interfaces</h2>\n" +
                                        "<ul>\n" +
                                        "  <li><strong>Command Palettes with Natural Language:</strong> A universal action surface that accepts typed or spoken intent, maps to structured commands, and explains results.</li>\n" +
                                        "  <li><strong>Explain-Then-Act:</strong> Before applying AI changes, the UI previews the action, rationale, and scope, allowing quick revisions.</li>\n" +
                                        "  <li><strong>Progressive Disclosure:</strong> AI powers concise summaries first, with drill-downs for detail and provenance to maintain trust.</li>\n" +
                                        "  <li><strong>Human-in-the-Loop Editing:</strong> Inline, reversible edits keep the user in control—no hidden, irreversible automation.</li>\n" +
                                        "  <li><strong>Confidence and State Indicators:</strong> Confidence badges, loading states, and safety rails set expectations and reduce surprise.</li>\n" +
                                        "</ul>\n" +
                                        "\n" +
                                        "<h2>Personalization, Privacy, and Trust</h2>\n" +
                                        "<p>Personalization works when it respects autonomy and privacy. The future leans on privacy-preserving techniques—on-device inference, federated learning, and differential privacy—to tailor experiences without leaking sensitive data. Consent surfaces should be granular, readable, and revisitable. Transparency matters: show why a suggestion appeared, what signals were used, and how to adjust preferences. Users must be able to override, mute, or reset personalization quickly. Trust also hinges on representational fairness: ensuring that model outputs do not marginalize groups through biased datasets or narrow personas. Inclusive testing—across languages, abilities, and cultures—becomes a baseline, not a bonus.</p>\n" +
                                        "\n" +
                                        "<h2>Accessibility as a First-Class Outcome</h2>\n" +
                                        "<p>AI can dramatically improve accessibility. Real-time captioning, image description, voice navigation, and reading-level adaptation democratize content. Layouts can shift to high-contrast or large-type modes automatically when system settings or ambient conditions suggest it. Gesture and gaze tracking broaden input options for users with mobility limitations. Still, automation must be audited: autogenerated alt text or summaries require validation, and fallback mechanisms must be clear and reliable. The standard is not merely compliance; it is dignity—giving every user a sense of mastery and comfort in the interface.</p>\n" +
                                        "\n" +
                                        "<h2>Challenges and Trade-Offs</h2>\n" +
                                        "<p>AI introduces complexity that must be acknowledged and managed. Over-personalization can erode learnability and shared mental models; teams should maintain stable anchors—consistent navigation, component behaviors, and universal shortcuts. Latency and reliability are critical: degraded network or model timeouts must fail gracefully to a usable baseline UI. Vendor lock-in and data residency constraints shape architecture choices; portability via open formats and edge inference will matter more. Finally, ethical review becomes a continuous responsibility: monitor for drift, hallucination, coercive nudges, and dark-pattern creep. Governance should include red-teaming, incident playbooks, and sunset criteria for underperforming features.</p>\n" +
                                        "\n" +
                                        "<h2>Measuring Outcomes, Not Hype</h2>\n" +
                                        "<p>The value of AI in UI should be proven with multi-dimensional metrics. Beyond click-through, teams track task completion time, error recovery, confidence ratings, accessibility usage, and satisfaction deltas for new versus returning users. Qualitative probes—think-aloud sessions, longitudinal diaries—reveal how AI affects trust and mental models. Observability pipelines capture prompt versions, model responses, user edits, and rollback reasons (with privacy controls) to diagnose failures and improve prompts and policies. AI features must earn their keep; if a non-AI solution is simpler, more predictable, and just as effective, choose it.</p>\n" +
                                        "\n" +
                                        "<blockquote>“Great interfaces don’t feel ‘smart’—they make people feel capable. AI’s job is to clear the path, not take the steps for us.”</blockquote>\n" +
                                        "\n" +
                                        "<h2>Tooling and Architecture</h2>\n" +
                                        "<p>Expect tighter loops between design tools, component libraries, and inference runtimes. Design tokens and accessibility rulesets can be compiled into prompts and validation checks. Component kits will ship with AI-ready variants—explain panels, confidence chips, redaction slots, and provenance drawers. Architecturally, hybrid inference will dominate: small, specialized models at the edge for low-latency tasks (classification, intent parsing) and larger models in the cloud for generation and reasoning. Caching, streaming, and incremental regeneration will keep interfaces responsive. Content safety and PII redaction middleware will sit between UI and model, enforcing policy in real time.</p>\n" +
                                        "\n" +
                                        "<h2>Skills for the Next-Gen Designer</h2>\n" +
                                        "<p>Designers will blend visual craft with systems thinking, prompt authoring, data literacy, and ethical judgment. They will prototype with actual models early, not static mocks, to evaluate behavior under uncertainty. Collaboration with research, data science, and engineering deepens as teams co-own metrics, guardrails, and rollout strategies. Documentation evolves from static specs to living policies and test suites that verify accessibility, safety, and performance. The craft expands—but its heart remains: empathy, clarity, and a relentless focus on the user’s goal.</p>\n" +
                                        "\n" +
                                        "<h2>The Road Ahead</h2>\n" +
                                        "<p>As AI becomes a design substrate rather than a bolt-on, interfaces will feel more conversational, anticipatory, and forgiving. Users will mold products in situ—teaching systems their preferences, vocabulary, and constraints—while transparent controls keep power in human hands. Standards will mature for provenance, consent, and portability, reducing fragmentation and fear. The winning products will not be the most “intelligent” in abstract terms, but the most supportive: fast, understandable, inclusive, and respectful. In that future, modern interface design is not a canvas to fill but a choreography to guide—where AI helps orchestrate the right move at the right moment, and the user still leads.</p>",
                                "2 hours ago",
                                "https://cdn.dailycrisp.me/ai.avif",
                                "https://cdn.dailycrisp.me/ai.avif",
                                sarahChen);
                articleService.addArticle(article4);
        }
}