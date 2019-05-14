classdef mynb
    methods(Static)
        
        function m = fit(train_examples, train_labels)
            
            m.unique_classes = unique(train_labels);
            m.n_classes = length(m.unique_classes);

            m.means = {};
            m.stds = {};
            
            for i = 1:m.n_classes
            
				this_class = m.unique_classes(i);
                examples_from_this_class = train_examples{train_labels==this_class,:};
                m.means{end+1} = mean(examples_from_this_class);
                m.stds{end+1} = std(examples_from_this_class);
            
			end
            
            m.priors = [];
            
            for i = 1:m.n_classes
                
				this_class = m.unique_classes(i);
                examples_from_this_class = train_examples{train_labels==this_class,:};
                m.priors(end+1) = size(examples_from_this_class,1) / size(train_labels,1);
            
			end

        end

        function predictions = predict(m, test_examples)

            predictions = categorical;

            for i=1:size(test_examples,1)

				fprintf('classifying example %i/%i\n', i, size(test_examples,1));
                this_test_example = test_examples{i,:};
                this_prediction = mynb.predict_one(m, this_test_example);
                predictions(end+1) = this_prediction;
            
			end
        end

        function prediction = predict_one(m, this_test_example)

            for i=1:m.n_classes

				this_likelihood = mynb.calculate_likelihood(m, this_test_example, i);
                this_prior = mynb.get_prior(m, i);
                posterior_(i) = this_likelihood * this_prior;
            
			end

            [winning_value_, winning_index] = max(posterior_);
            prediction = m.unique_classes(winning_index);

        end
        
        function likelihood = calculate_likelihood(m, this_test_example, class)
            
			likelihood = 1;
            
			for i=1:length(this_test_example)
                likelihood = likelihood * mynb.calculate_pd(this_test_example(i), m.means{class}(i), m.stds{class}(i));
            end
        end
        
        function prior = get_prior(m, class)
            
			prior = m.priors(class);
        
		end
        
        function pd = calculate_pd(x, mu, sigma)
        
			first_bit = 1 / sqrt(2*pi*sigma^2);
            second_bit = - ( ((x-mu)^2) / (2*sigma^2) );
            pd = first_bit * exp(second_bit);
        
		end
            
    end
end