package com.shuttle.exer.sort.executor;

public enum SortExecutorEnum {

    BUBBLE_SORT_V1("Bubble Sort Version I", new BubbleSortV1Executor()),
    BUBBLE_SORT_V2("Bubble Sort Version II", new BubbleSortV2Executor()),
    SELECT_SORT_V1("Select Sort Version I", new SelectSortV1Executor()),
    SELECT_SORT_V2("Select Sort Version II", new SelectSortV2Executor()),
    INSERT_SORT_V1("Insert Sort Version I", new InsertSortV1Executor()),
    INSERT_SORT_V2("Insert Sort Version II", new InsertSortV2Executor()),
    SHELL_SORT_V1("Shell Sort Version I", new ShellSortV1Executor()),
    QUICK_SORT_V1("Quick Sort Version I", new QuickSortV1Executor()),
    MERGE_SORT_V1("Merge Sort Version I", new MergeSortV1Executor()),
    HEAP_SORT_V1("Heap Sort Version I", new HeapSortV1Executor()),
    JDK_SORT("JDK Sort", new JDKSortExecutor());

    private final String executorName;

    private final SortExecutor executor;

    SortExecutorEnum(String executorName, SortExecutor executor) {
        this.executorName = executorName;
        this.executor = executor;
    }

    public String getExecutorName() {
        return this.executorName;
    }

    public SortExecutor getExecutor() {
        return this.executor;
    }

}
