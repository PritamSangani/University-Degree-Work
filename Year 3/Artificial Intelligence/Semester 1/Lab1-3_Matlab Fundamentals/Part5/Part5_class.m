classdef Part5_class
    methods(Static)
        function m = createModel(examples, labels, parameters)
            % set up a structure containing model info:
            m.examples = examples;
            m.labels = labels;
            m.parameters = parameters;
            fprintf('model structure created\n');
        end
        function modelInfo(m)
            % print out summary of model information:
            fprintf('model contains:\n');
            fprintf('%d examples\n', size(m.examples,1));
            fprintf('Each with %d features\n', size(m.examples, 2));
            fprintf('And %d associated labels from %d classes\n', size(m.labels, 1), length(unique(m.labels)));
            fprintf('Model has %d parameters\n', size(m.parameters, 2));
        end
        function previewExamples(m)
            % have a look at first 10 rows of the examples table:
            fprintf('previewing first 10 training examples:\n');
            m.examples(1:1:10, :)
        end
        
        function plotScatter(col_1, col_2)
            scatter(col_1, col_2, 'MarkerFaceColor','r','MarkerEdgeColor','k')         
        end
    end
end

