# Java TDD & Pair-Programming Interview Prep Demo

A tiny Java + JUnit walkthrough of **red → green → refactor**, the style I use in Codementor pair sessions for interview prep and clearer technical English.

## What this repo shows

| Piece | Path | Purpose |
|-------|------|---------|
| Production code | `src/main/java/.../StringCalculator.java` | Classic kata: add numbers from a delimited string |
| Tests | `src/test/java/.../StringCalculatorTest.java` | Ordered examples that mirror a live TDD loop |
| Build | `pom.xml` | Maven + JUnit 5 — `mvn test` is enough |

No frameworks beyond JUnit. You can run the same flow in IntelliJ, VS Code, or plain terminal.

## Run the tests

```bash
mvn -q test
```

Expected: all tests green. During a session we often delete one assertion (or the implementation) to recreate the **red** step, then re-implement together.

## How I help as a Codementor tutor

- **TDD habit**: write the failing test first; keep steps small enough to narrate out loud
- **Pair programming**: ping-pong or driver/navigator — you speak the design; I keep pace and interrupt only when the loop breaks
- **Interview English**: practice explaining trade-offs (“why this test next?”) in clear, calm technical English
- **Kata → job**: map kata patterns onto real interview prompts (parsing, edge cases, error contracts)

## Sample pair-session agenda (60 min)

1. **Goals (5 min)** — Target role, language comfort, timeboxed interview format you expect.
2. **Red (10 min)** — Pick the next failing case (e.g. custom delimiter). Write the test before any production code.
3. **Green (15 min)** — Smallest change that passes. Resist cleverness.
4. **Refactor (10 min)** — Names, helpers, duplication — tests stay green.
5. **Communication drill (15 min)** — You explain the solution as if to an interviewer; I coach phrasing and structure.
6. **Takeaway (5 min)** — One homework kata + a short English checklist for your next mock.

## Suggested longer path

- Sessions 1–2: StringCalculator / FizzBuzz / bowling score with strict TDD
- Sessions 3–4: Collections, streams, and concurrency interview favorites
- Sessions 5+: Full mock interviews (45 min coding + 15 min feedback on English & design)

Bring a job description or a recent interview prompt — we’ll turn it into a focused pair session.
