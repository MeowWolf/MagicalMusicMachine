live_loop :test_notes do
  use_real_time
  s, n, a, p = sync "/osc*/sonic"
  
  begin
    synth s.to_s, note: n, amp: a, pan: p
  rescue
    puts 'I am rescued.'
    begin
      sample s.to_s, note: n, amp: a, pan: p
    rescue
      puts 'I am doubly rescued.'
    end
  end
end
