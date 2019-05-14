% A Class that implements the k-Nearest Neighbours Classifier
% Contains 7 functions: fit, predict, predict_one, calculate_distances,
% calculate_distance, find_nn_indices, make_prediction
classdef myknn 
    methods(Static)
       % fit - a function that trains a classifier using the k-NN algorithm
       % with the inputs being training-set examples, training-set labels 
       % and k (number of nearest neighbours you want to use in training)
        function m = fit(train_examples, train_labels, k)
            
       % start of standardisation process (using z-Score Standardisation):
           % standardisation allows us to rescale the value of each
           % feature so that the features lie in a similar range. 
           % Thereby, not allowing features with larger ranges to dominate 
           % the euclidian distance calculated 
        
       % Formula for z-Score Standardisation
            % X[new] = (X - Mean(X)) / StdDev(X) 
            % where X is any one feature
% --------------------------------------------------------------------------
			m.mean = mean(train_examples{:,:});
			m.std = std(train_examples{:,:});
            for i=1:size(train_examples,1)
				train_examples{i,:} = train_examples{i,:} - m.mean;
                train_examples{i,:} = train_examples{i,:} ./ m.std;
            end
            % end of standardisation process
            
           % store the standardised train_examples as a field of the 'm'
           % structure, so that it can be used during prediction and
           % beyond.
            m.train_examples = train_examples;
           % also store the train_labels and the k as fields in the struct
           % so all inputs are available to be called from one structure.
            m.train_labels = train_labels;
            m.k = k;
        
        end
        
       % predict - a function to classify the testing-set examples using 
       % the classifier trained using the fit function. The inputs are m,
       % the trained classifier and test_examples, the examples (without
       % the labels) from the training-set.
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

