# Design System

## Stack

- framework: Java Swing
- styling: Java Look and Feel Nimbus, com componentes Swing nativos
- components: formulário de consulta e atualização de conta bancária
- animation: não aplicável ao escopo desktop da atividade

## Decisions

- 2026-10-05 — Sistema Bancário: campos organizados por identificação da conta e dados do cliente; ações explícitas de consultar, atualizar/cadastrar e fechar.

## Components

- `src/Janela.java` — tela principal do sistema bancário.

## Non-Goals

- Persistência em banco de dados; os dados são mantidos em memória durante a execução.
