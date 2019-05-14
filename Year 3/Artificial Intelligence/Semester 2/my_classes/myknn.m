classdef myknn
    methods(Static)
        
        function m = fit(train_examples, train_labels, k)
            
            % start of standardisation process
			m.mean = mean(train_examples{:,:});
			m.std = std(train_examples{:,:});
            for i=1:size(train_examples,1)
				train_examples{i,:} = train_examples{i,:} - m.mean;
                train_examples{i,:} = train_examples{i,:} ./ m.std;
            end
            % end of standardisation process
            
            m.train_examples = train_examples;
            m.train_labels = train_labels;
            m.k = k;
        
        end

        function predictions = predict(m, test_examples)

            predictions = categorical;

            for i=1:size(test_examples,1)
                
                fprintf('classifying example example %i/%i\n', i, size(test_examples,1));
                
                this_test_example = test_examples{i,:};
                
                % start of standardisation process
                this_test_example = this_test_example - m.mean;
                this_test_example = this_test_example ./ m.std;
                % end of standardisation process
                
                this_prediction = myknn.predict_one(m, this_test_example);
                predictions(end+1) = this_prediction;
            
            end
        
		end

        function prediction = predict_one(m, this_test_example)
            
            distances = myknn.calculate_distances(m, this_test_example);
            neighbour_indices = myknn.find_nn_indices(m, distances);
            prediction = myknn.make_prediction(m, neighbour_indices);
        
        end

        function distances = calculate_distances(m, this_test_example)
            
			distances = [];
            
			for i=1:size(m.train_examples,1)
                
				this_training_example = m.train_examples{i,:};
                this_distance = myknn.calculate_distance(this_training_example, this_test_example);
                distances(end+1) = this_distance;
            end
        
		end

        function distance = calculate_distance(p, q)
            
			differences = q - p;
            squares = differences .^ 2;
            total = sum(squares);
            distance = sqrt(total);
        
		end

        function neighbour_indices = find_nn_indices(m, distances)
            
			[sorted, indices] = sort(distances);
            neighbour_indices = indices(1:m.k);
        
		end
        
        function prediction = make_prediction(m, neighbour_indices)

			neighbour_labels = m.train_labels(neighbour_indices);
            prediction = mode(neighbour_labels);
        
		end

    end
end

