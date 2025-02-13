# kotlinx-coroutines-core

## `package` : _`kotlinx.coroutines.flow`_

### `Classes`
> **`Flow`**, **`FlowCollector`**, **`AbstractFlow`**, **`ChannelFlow`**, **`SafeCollector`**, **`CancellableFlow`**, **`FlowKt__CollectKt`**, **`CoroutineScope`**, **`Job`**, **`Continuation`**, **`FlowKt__EmittersKt`**

```mermaid
classDiagram
    direction BT

    class Flow {
        <<interface>>
        +collect(collector: FlowCollector)
    }
    class FlowCollector {
        <<interface>>
        +emit(value: T)
    }
    class AbstractFlow {
        <<abstract>>
        #collectSafely(collector: FlowCollector)
        +collect(collector: FlowCollector)
    }
    class ChannelFlow {
        <<abstract>>
        +produceImpl(scope: CoroutineScope, collector: FlowCollector)
    }
    class SafeCollector {
        +emit(value: T)
    }
    class CancellableFlow {
        +collect(collector: FlowCollector)
    }
    class FlowKt__CollectKt {
        <<utility>>
        +collect(flow: Flow, collector: FlowCollector)
    }
    class CoroutineScope {
        <<interface>>
    }
    class Job {
        <<interface>>
    }
    class Continuation {
        <<interface>>
    }
    class FlowKt__EmittersKt {
        <<utility>>
        +emit(value: T)
    }

    Flow <|-- AbstractFlow : implements
    Flow <|-- ChannelFlow : implements
    Flow <|-- CancellableFlow : implements
    FlowCollector <|-- SafeCollector : implements
    AbstractFlow --|> FlowCollector : uses
    ChannelFlow --|> CoroutineScope : uses
    FlowKt__CollectKt ..> Flow : uses
    FlowKt__CollectKt ..> FlowCollector : uses
    FlowKt__EmittersKt ..> FlowCollector : uses
    CoroutineScope --|> Job : uses
    SafeCollector --|> Continuation : uses
```

### Package Contents
> Class Details

| Class               | Type       | Methods                                      |
|---------------------|------------|----------------------------------------------|
| Flow                | Interface  | + collect(collector: FlowCollector)          |
| FlowCollector       | Interface  | + emit(value: T)                             |
| AbstractFlow        | Abstract   | # collectSafely(collector: FlowCollector)    |
|                     |            | + collect(collector: FlowCollector)          |
| ChannelFlow         | Abstract   | + produceImpl(scope: CoroutineScope, collector: FlowCollector) |
| SafeCollector       |            | + emit(value: T)                             |
| CancellableFlow     |            | + collect(collector: FlowCollector)          |
| FlowKt__CollectKt   | Utility    | + collect(flow: Flow, collector: FlowCollector) |
| CoroutineScope      | Interface  |                                              |
| Job                 | Interface  |                                              |
| Continuation        | Interface  |                                              |
| FlowKt__EmittersKt  | Utility    | + emit(value: T)                             |